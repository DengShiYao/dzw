"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.isEnableConf = isEnableConf;
exports.default = exports.UtilTools = void 0;

var _ctor = _interopRequireDefault(require("xe-utils/ctor"));

var _conf = _interopRequireDefault(require("../../conf"));

var _formats = _interopRequireDefault(require("../../v-x-e-table/src/formats"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _toConsumableArray(arr) { return _arrayWithoutHoles(arr) || _iterableToArray(arr) || _unsupportedIterableToArray(arr) || _nonIterableSpread(); }

function _nonIterableSpread() { throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method."); }

function _unsupportedIterableToArray(o, minLen) { if (!o) return; if (typeof o === "string") return _arrayLikeToArray(o, minLen); var n = Object.prototype.toString.call(o).slice(8, -1); if (n === "Object" && o.constructor) n = o.constructor.name; if (n === "Map" || n === "Set") return Array.from(o); if (n === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return _arrayLikeToArray(o, minLen); }

function _iterableToArray(iter) { if (typeof Symbol !== "undefined" && Symbol.iterator in Object(iter)) return Array.from(iter); }

function _arrayWithoutHoles(arr) { if (Array.isArray(arr)) return _arrayLikeToArray(arr); }

function _arrayLikeToArray(arr, len) { if (len == null || len > arr.length) len = arr.length; for (var i = 0, arr2 = new Array(len); i < len; i++) { arr2[i] = arr[i]; } return arr2; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var zindexIndex = 0;
var lastZindex = 1;

var ColumnInfo = /*#__PURE__*/function () {
  /* eslint-disable @typescript-eslint/no-use-before-define */
  function ColumnInfo($xetable, _vm) {
    var _ref = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {},
        renderHeader = _ref.renderHeader,
        renderCell = _ref.renderCell,
        renderFooter = _ref.renderFooter,
        renderData = _ref.renderData;

    _classCallCheck(this, ColumnInfo);

    var $xegrid = $xetable.$xegrid;
    var proxyOpts = $xegrid ? $xegrid.proxyOpts : null;
    var formatter = _vm.formatter;
    var visible = _ctor.default.isBoolean(_vm.visible) ? _vm.visible : true;

    if (process.env.VUE_APP_VXE_TABLE_ENV === 'development') {
      var types = ['seq', 'checkbox', 'radio', 'expand', 'html'];

      if (_vm.type && types.indexOf(_vm.type) === -1) {
        UtilTools.warn('vxe.error.errProp', ["type=".concat(_vm.type), types.join(', ')]);
      }

      if (_ctor.default.isBoolean(_vm.cellRender) || _vm.cellRender && !_ctor.default.isObject(_vm.cellRender)) {
        UtilTools.warn('vxe.error.errProp', ["column.cell-render=".concat(_vm.cellRender), 'column.cell-render={}']);
      }

      if (_ctor.default.isBoolean(_vm.editRender) || _vm.editRender && !_ctor.default.isObject(_vm.editRender)) {
        UtilTools.warn('vxe.error.errProp', ["column.edit-render=".concat(_vm.editRender), 'column.edit-render={}']);
      }

      if (_vm.cellRender && _vm.editRender) {
        UtilTools.warn('vxe.error.errConflicts', ['column.cell-render', 'column.edit-render']);
      }

      if (_vm.type === 'expand') {
        if ($xetable.treeConfig && $xetable.treeOpts.line) {
          UtilTools.error('vxe.error.errConflicts', ['tree-config.line', 'column.type=expand']);
        }
      }

      if (_vm.remoteSort) {
        UtilTools.warn('vxe.error.delProp', ['column.remote-sort', 'sort-config.remote']);
      }

      if (_vm.sortMethod) {
        UtilTools.warn('vxe.error.delProp', ['column.sort-method', 'sort-config.sortMethod']);
      }

      if (formatter) {
        if (_ctor.default.isString(formatter)) {
          var globalFunc = _formats.default.get(formatter) || _ctor.default[formatter];

          if (!_ctor.default.isFunction(globalFunc)) {
            UtilTools.error('vxe.error.notFunc', [formatter]);
          }
        } else if (_ctor.default.isArray(formatter)) {
          var _globalFunc = _formats.default.get(formatter[0]) || _ctor.default[formatter[0]];

          if (!_ctor.default.isFunction(_globalFunc)) {
            UtilTools.error('vxe.error.notFunc', [formatter[0]]);
          }
        }
      }
    }

    Object.assign(this, {
      // 基本属性
      type: _vm.type,
      property: _vm.field,
      title: _vm.title,
      width: _vm.width,
      minWidth: _vm.minWidth,
      resizable: _vm.resizable,
      fixed: _vm.fixed,
      align: _vm.align,
      headerAlign: _vm.headerAlign,
      footerAlign: _vm.footerAlign,
      showOverflow: _vm.showOverflow,
      showHeaderOverflow: _vm.showHeaderOverflow,
      showFooterOverflow: _vm.showFooterOverflow,
      className: _vm.className,
      headerClassName: _vm.headerClassName,
      footerClassName: _vm.footerClassName,
      formatter: formatter,
      sortable: _vm.sortable,
      sortBy: _vm.sortBy,
      sortMethod: _vm.sortMethod,
      remoteSort: _vm.remoteSort,
      filters: UtilTools.getFilters(_vm.filters),
      filterMultiple: _ctor.default.isBoolean(_vm.filterMultiple) ? _vm.filterMultiple : true,
      filterMethod: _vm.filterMethod,
      filterRender: _vm.filterRender,
      treeNode: _vm.treeNode,
      cellType: _vm.cellType,
      cellRender: _vm.cellRender,
      editRender: _vm.editRender,
      contentRender: _vm.contentRender,
      exportMethod: _vm.exportMethod,
      footerExportMethod: _vm.footerExportMethod,
      titleHelp: _vm.titleHelp,
      // 自定义参数
      params: _vm.params,
      // 渲染属性
      id: _vm.colId || _ctor.default.uniqueId('col_'),
      parentId: null,
      visible: visible,
      halfVisible: false,
      defaultVisible: visible,
      checked: false,
      halfChecked: false,
      disabled: false,
      level: 1,
      rowSpan: 1,
      colSpan: 1,
      order: null,
      renderWidth: 0,
      renderHeight: 0,
      resizeWidth: 0,
      renderLeft: 0,
      renderArgs: [],
      // 渲染参数可用于扩展
      model: {},
      renderHeader: renderHeader || _vm.renderHeader,
      renderCell: renderCell || _vm.renderCell,
      renderFooter: renderFooter || _vm.renderFooter,
      renderData: renderData,
      // 单元格插槽，只对 grid 有效
      slots: _vm.slots
    });

    if (proxyOpts && proxyOpts.beforeColumn) {
      proxyOpts.beforeColumn({
        $grid: $xegrid,
        column: this
      });
    }
  }

  _createClass(ColumnInfo, [{
    key: "getTitle",
    value: function getTitle() {
      return UtilTools.getFuncText(this.title || (this.type === 'seq' ? _conf.default.i18n('vxe.table.seqTitle') : ''));
    }
  }, {
    key: "getKey",
    value: function getKey() {
      return this.property || (this.type ? "type=".concat(this.type) : null);
    }
  }, {
    key: "update",
    value: function update(name, value) {
      // 不支持双向的属性
      if (name !== 'filters') {
        if (name === 'field') {
          this.property = value;
        } else {
          this[name] = value;
        }
      }
    }
  }]);

  return ColumnInfo;
}();

function isEnableConf(conf) {
  return conf && conf.enabled !== false;
}

function outLog(type) {
  return function (message, params) {
    var msg = UtilTools.getLog(message, params);
    console[type](msg);
    return msg;
  };
}

var UtilTools = {
  warn: outLog('warn'),
  error: outLog('error'),
  getLog: function getLog(message, args) {
    return "[vxe-table] ".concat(_conf.default.i18n(message, args));
  },
  getFuncText: function getFuncText(content) {
    return _ctor.default.isFunction(content) ? content() : _conf.default.translate ? _conf.default.translate(content) : content;
  },
  nextZIndex: function nextZIndex() {
    lastZindex = _conf.default.zIndex + zindexIndex++;
    return lastZindex;
  },
  getLastZIndex: function getLastZIndex() {
    return lastZindex;
  },
  // 行主键 key
  getRowkey: function getRowkey($xetable) {
    return $xetable.rowId || '_XID';
  },
  // 行主键 value
  getRowid: function getRowid($xetable, row) {
    var rowId = _ctor.default.get(row, UtilTools.getRowkey($xetable));

    return rowId ? encodeURIComponent(rowId) : '';
  },
  // 获取所有的列，排除分组
  getColumnList: function getColumnList(columns) {
    var result = [];
    columns.forEach(function (column) {
      result.push.apply(result, _toConsumableArray(column.children && column.children.length ? UtilTools.getColumnList(column.children) : [column]));
    });
    return result;
  },
  getClass: function getClass(property, params) {
    return property ? _ctor.default.isFunction(property) ? property(params) : property : '';
  },
  getFilters: function getFilters(filters) {
    if (filters && _ctor.default.isArray(filters)) {
      return filters.map(function (_ref2) {
        var label = _ref2.label,
            value = _ref2.value,
            data = _ref2.data,
            resetValue = _ref2.resetValue,
            checked = _ref2.checked;
        return {
          label: label,
          value: value,
          data: data,
          resetValue: resetValue,
          checked: !!checked,
          _checked: !!checked
        };
      });
    }

    return filters;
  },
  formatText: function formatText(value, placeholder) {
    return '' + (value === '' || value === null || value === undefined ? placeholder ? _conf.default.emptyCell : '' : value);
  },
  getCellValue: function getCellValue(row, column) {
    return _ctor.default.get(row, column.property);
  },
  setCellValue: function setCellValue(row, column, value) {
    return _ctor.default.set(row, column.property, value);
  },
  isColumn: function isColumn(column) {
    return column instanceof ColumnInfo;
  },
  getColumnConfig: function getColumnConfig($xetable, _vm, options) {
    return UtilTools.isColumn(_vm) ? _vm : new ColumnInfo($xetable, _vm, options);
  },
  // 组装列配置
  assemColumn: function assemColumn(_vm) {
    var $el = _vm.$el,
        $xetable = _vm.$xetable,
        $xecolumn = _vm.$xecolumn,
        columnConfig = _vm.columnConfig;
    var groupConfig = $xecolumn ? $xecolumn.columnConfig : null;
    columnConfig.slots = _vm.$scopedSlots;

    if (groupConfig) {
      if (process.env.VUE_APP_VXE_TABLE_ENV === 'development') {
        if ($xecolumn.$options._componentTag === 'vxe-table-column') {
          UtilTools.warn('vxe.error.groupTag', ["<vxe-table-colgroup title=".concat($xecolumn.title, " ...>"), "<vxe-table-column title=".concat($xecolumn.title, " ...>")]);
        }
      }

      if (!groupConfig.children) {
        groupConfig.children = [];
      }

      groupConfig.children.splice([].indexOf.call($xecolumn.$el.children, $el), 0, columnConfig);
    } else {
      $xetable.staticColumns.splice([].indexOf.call($xetable.$refs.hideColumn.children, $el), 0, columnConfig);
    }
  },
  // 销毁列
  destroyColumn: function destroyColumn(_vm) {
    var $xetable = _vm.$xetable,
        columnConfig = _vm.columnConfig;

    var matchObj = _ctor.default.findTree($xetable.staticColumns, function (column) {
      return column === columnConfig;
    });

    if (matchObj) {
      matchObj.items.splice(matchObj.index, 1);
    }
  },
  hasChildrenList: function hasChildrenList(item) {
    return item && item.children && item.children.length > 0;
  },
  parseFile: function parseFile(file) {
    var name = file.name;

    var tIndex = _ctor.default.lastIndexOf(name, '.');

    var type = name.substring(tIndex + 1, name.length);
    var filename = name.substring(0, tIndex);
    return {
      filename: filename,
      type: type
    };
  },
  isNumVal: function isNumVal(num) {
    return !isNaN(parseFloat('' + num));
  }
};
exports.UtilTools = UtilTools;
var _default = UtilTools;
exports.default = _default;