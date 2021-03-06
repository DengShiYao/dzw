"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.handleFieldOrColumn = handleFieldOrColumn;
exports.getColMinWidth = getColMinWidth;
exports.getOffsetSize = getOffsetSize;
exports.calcTreeLine = calcTreeLine;
exports.mergeBodyMethod = mergeBodyMethod;
exports.clearTableDefaultStatus = clearTableDefaultStatus;
exports.clearTableAllStatus = clearTableAllStatus;

var _vXETable = _interopRequireDefault(require("../../v-x-e-table"));

var _xeUtils = _interopRequireDefault(require("xe-utils"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var lineOffsetSizes = {
  mini: 3,
  small: 2,
  medium: 1
};

function getPaddingLeftRightSize(elem) {
  if (elem) {
    var computedStyle = getComputedStyle(elem);

    var paddingLeft = _xeUtils.default.toNumber(computedStyle.paddingLeft);

    var paddingRight = _xeUtils.default.toNumber(computedStyle.paddingRight);

    return paddingLeft + paddingRight;
  }

  return 0;
}

function getElemenMarginWidth(elem) {
  if (elem) {
    var computedStyle = getComputedStyle(elem);

    var marginLeft = _xeUtils.default.toNumber(computedStyle.marginLeft);

    var marginRight = _xeUtils.default.toNumber(computedStyle.marginRight);

    return elem.offsetWidth + marginLeft + marginRight;
  }

  return 0;
}

function handleFieldOrColumn(_vm, fieldOrColumn) {
  if (fieldOrColumn) {
    return _xeUtils.default.isString(fieldOrColumn) ? _vm.getColumnByField(fieldOrColumn) : fieldOrColumn;
  }

  return null;
}

function queryCellElement(cell, selector) {
  return cell.querySelector('.vxe-cell' + selector);
}

function getColMinWidth(params) {
  var $table = params.$table,
      column = params.column,
      cell = params.cell;
  var allColumnHeaderOverflow = $table.showHeaderOverflow,
      resizableOpts = $table.resizableOpts;
  var minWidth = resizableOpts.minWidth;

  if (minWidth) {
    var customMinWidth = _xeUtils.default.isFunction(minWidth) ? minWidth(params) : minWidth;

    if (customMinWidth !== 'auto') {
      return Math.max(1, _xeUtils.default.toNumber(customMinWidth));
    }
  }

  var showHeaderOverflow = column.showHeaderOverflow;
  var headOverflow = _xeUtils.default.isUndefined(showHeaderOverflow) || _xeUtils.default.isNull(showHeaderOverflow) ? allColumnHeaderOverflow : showHeaderOverflow;
  var showEllipsis = headOverflow === 'ellipsis';
  var showTitle = headOverflow === 'title';
  var showTooltip = headOverflow === true || headOverflow === 'tooltip';
  var hasEllipsis = showTitle || showTooltip || showEllipsis;

  var minTitleWidth = _xeUtils.default.floor((_xeUtils.default.toNumber(getComputedStyle(cell).fontSize) || 14) * 1.6);

  var paddingLeftRight = getPaddingLeftRightSize(cell) + getPaddingLeftRightSize(queryCellElement(cell, ''));
  var colMinWidth = minTitleWidth + paddingLeftRight;

  if (hasEllipsis) {
    var checkboxIconWidth = getPaddingLeftRightSize(queryCellElement(cell, '--title>.vxe-cell--checkbox'));
    var requiredIconWidth = getElemenMarginWidth(queryCellElement(cell, '>.vxe-cell--required-icon'));
    var editIconWidth = getElemenMarginWidth(queryCellElement(cell, '>.vxe-cell--edit-icon'));
    var helpIconWidth = getElemenMarginWidth(queryCellElement(cell, '>.vxe-cell-help-icon'));
    var sortIconWidth = getElemenMarginWidth(queryCellElement(cell, '>.vxe-cell--sort'));
    var filterIconWidth = getElemenMarginWidth(queryCellElement(cell, '>.vxe-cell--filter'));
    colMinWidth += checkboxIconWidth + requiredIconWidth + editIconWidth + helpIconWidth + filterIconWidth + sortIconWidth;
  }

  return colMinWidth;
}

function countTreeExpand(prevRow, params) {
  var $table = params.$table;
  var rowChildren = prevRow[$table.treeOpts.children];
  var count = 1;

  if ($table.isTreeExpandByRow(prevRow)) {
    for (var index = 0; index < rowChildren.length; index++) {
      count += countTreeExpand(rowChildren[index], params);
    }
  }

  return count;
}

function getOffsetSize($xetable) {
  return lineOffsetSizes[$xetable.vSize] || 0;
}

function calcTreeLine(params, items) {
  var $table = params.$table,
      $rowIndex = params.$rowIndex;
  var expandSize = 1;

  if ($rowIndex) {
    expandSize = countTreeExpand(items[$rowIndex - 1], params);
  }

  return $table.rowHeight * expandSize - ($rowIndex ? 1 : 12 - getOffsetSize($table));
}

function mergeBodyMethod(mergeList, _rowIndex, _columnIndex) {
  for (var mIndex = 0; mIndex < mergeList.length; mIndex++) {
    var _mergeList$mIndex = mergeList[mIndex],
        mergeRowIndex = _mergeList$mIndex.row,
        mergeColIndex = _mergeList$mIndex.col,
        mergeRowspan = _mergeList$mIndex.rowspan,
        mergeColspan = _mergeList$mIndex.colspan;

    if (mergeColIndex > -1 && mergeRowIndex > -1 && mergeRowspan && mergeColspan) {
      if (mergeRowIndex === _rowIndex && mergeColIndex === _columnIndex) {
        return {
          rowspan: mergeRowspan,
          colspan: mergeColspan
        };
      }

      if (_rowIndex >= mergeRowIndex && _rowIndex < mergeRowIndex + mergeRowspan && _columnIndex >= mergeColIndex && _columnIndex < mergeColIndex + mergeColspan) {
        return {
          rowspan: 0,
          colspan: 0
        };
      }
    }
  }
}

function clearTableDefaultStatus(_vm) {
  _vm.initStatus = false;

  _vm.clearSort();

  _vm.clearCurrentRow();

  _vm.clearCurrentColumn();

  _vm.clearRadioRow();

  _vm.clearRadioReserve();

  _vm.clearCheckboxRow();

  _vm.clearCheckboxReserve();

  _vm.clearRowExpand();

  _vm.clearTreeExpand();

  _vm.clearTreeExpandReserve();

  if (_vm.clearActived && _vXETable.default._edit) {
    _vm.clearActived();
  }

  if (_vm.clearSelected && (_vm.keyboardConfig || _vm.mouseConfig)) {
    _vm.clearSelected();
  }

  if (_vm.clearCellAreas && _vm.mouseConfig) {
    _vm.clearCellAreas();

    _vm.clearCopyCellArea();
  }

  return _vm.clearScroll();
}

function clearTableAllStatus(_vm) {
  if (_vm.clearFilter && _vXETable.default._filter) {
    _vm.clearFilter();
  }

  return clearTableDefaultStatus(_vm);
}