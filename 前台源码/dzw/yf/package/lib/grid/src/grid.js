"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _table = _interopRequireDefault(require("../../table"));

var _ctor = _interopRequireDefault(require("xe-utils/ctor"));

var _conf = _interopRequireDefault(require("../../conf"));

var _size = _interopRequireDefault(require("../../mixins/size"));

var _vXETable = _interopRequireDefault(require("../../v-x-e-table"));

var _tools = require("../../tools");

var _util = require("../../table/src/util");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _toConsumableArray(arr) { return _arrayWithoutHoles(arr) || _iterableToArray(arr) || _unsupportedIterableToArray(arr) || _nonIterableSpread(); }

function _nonIterableSpread() { throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method."); }

function _unsupportedIterableToArray(o, minLen) { if (!o) return; if (typeof o === "string") return _arrayLikeToArray(o, minLen); var n = Object.prototype.toString.call(o).slice(8, -1); if (n === "Object" && o.constructor) n = o.constructor.name; if (n === "Map" || n === "Set") return Array.from(o); if (n === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return _arrayLikeToArray(o, minLen); }

function _iterableToArray(iter) { if (typeof Symbol !== "undefined" && Symbol.iterator in Object(iter)) return Array.from(iter); }

function _arrayWithoutHoles(arr) { if (Array.isArray(arr)) return _arrayLikeToArray(arr); }

function _arrayLikeToArray(arr, len) { if (len == null || len > arr.length) len = arr.length; for (var i = 0, arr2 = new Array(len); i < len; i++) { arr2[i] = arr[i]; } return arr2; }

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { _defineProperty(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var methods = {};
var propKeys = Object.keys(_table.default.props);

function getOffsetHeight(elem) {
  return elem ? elem.offsetHeight : 0;
}

function getPaddingTopBottomSize(elem) {
  if (elem) {
    var computedStyle = getComputedStyle(elem);

    var paddingTop = _ctor.default.toNumber(computedStyle.paddingTop);

    var paddingBottom = _ctor.default.toNumber(computedStyle.paddingBottom);

    return paddingTop + paddingBottom;
  }

  return 0;
}

function renderDefaultForm(h, _vm) {
  var proxyConfig = _vm.proxyConfig,
      proxyOpts = _vm.proxyOpts,
      formData = _vm.formData,
      formConfig = _vm.formConfig,
      formOpts = _vm.formOpts;

  if ((0, _tools.isEnableConf)(formConfig) && formOpts.items && formOpts.items.length) {
    if (!formOpts.inited) {
      formOpts.inited = true;
      var beforeItem = proxyOpts.beforeItem;

      if (proxyOpts && beforeItem) {
        formOpts.items.forEach(function (item) {
          beforeItem.call(_vm, {
            $grid: _vm,
            item: item
          });
        });
      }
    }

    return [h('vxe-form', {
      props: Object.assign({}, formOpts, {
        data: proxyConfig && proxyOpts.form ? formData : formOpts.data
      }),
      on: {
        submit: _vm.submitEvent,
        reset: _vm.resetEvent,
        'submit-invalid': _vm.submitInvalidEvent,
        'toggle-collapse': _vm.togglCollapseEvent
      }
    })];
  }

  return [];
}

function getToolbarSlots(_vm) {
  var $scopedSlots = _vm.$scopedSlots,
      toolbarOpts = _vm.toolbarOpts;
  var toolbarOptSlots = toolbarOpts.slots;
  var $buttons;
  var $tools;
  var slots = {};

  if (toolbarOptSlots) {
    $buttons = toolbarOptSlots.buttons;
    $tools = toolbarOptSlots.tools;

    if ($buttons && $scopedSlots[$buttons]) {
      $buttons = $scopedSlots[$buttons];
    }

    if ($tools && $scopedSlots[$tools]) {
      $tools = $scopedSlots[$tools];
    }
  }

  if ($buttons) {
    slots.buttons = $buttons;
  }

  if ($tools) {
    slots.tools = $tools;
  }

  return slots;
}

function getPagerSlots(_vm) {
  var $scopedSlots = _vm.$scopedSlots,
      pagerOpts = _vm.pagerOpts;
  var pagerOptSlots = pagerOpts.slots;
  var slots = {};
  var $left;
  var $right;

  if (pagerOptSlots) {
    $left = pagerOptSlots.left;
    $right = pagerOptSlots.right;

    if ($left && $scopedSlots[$left]) {
      $left = $scopedSlots[$left];
    }

    if ($right && $scopedSlots[$right]) {
      $right = $scopedSlots[$right];
    }
  }

  if ($left) {
    slots.left = $left;
  }

  if ($right) {
    slots.right = $right;
  }

  return slots;
}

function getTableOns(_vm) {
  var $listeners = _vm.$listeners,
      proxyConfig = _vm.proxyConfig,
      proxyOpts = _vm.proxyOpts;
  var ons = {};

  _ctor.default.each($listeners, function (cb, type) {
    ons[type] = function () {
      for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
        args[_key] = arguments[_key];
      }

      _vm.$emit.apply(_vm, [type].concat(args));
    };
  });

  if (proxyConfig) {
    if (proxyOpts.sort) {
      ons['sort-change'] = _vm.sortChangeEvent;
    }

    if (proxyOpts.filter) {
      ons['filter-change'] = _vm.filterChangeEvent;
    }
  }

  return ons;
}

Object.keys(_table.default.methods).forEach(function (name) {
  methods[name] = function () {
    var _this$$refs$xTable;

    return this.$refs.xTable && (_this$$refs$xTable = this.$refs.xTable)[name].apply(_this$$refs$xTable, arguments);
  };
});
var _default2 = {
  name: 'VxeGrid',
  mixins: [_size.default],
  props: _objectSpread(_objectSpread({}, _table.default.props), {}, {
    columns: Array,
    pagerConfig: [Boolean, Object],
    proxyConfig: Object,
    toolbar: [Boolean, Object],
    toolbarConfig: [Boolean, Object],
    formConfig: [Boolean, Object],
    zoomConfig: Object,
    size: {
      type: String,
      default: function _default() {
        return _conf.default.grid.size || _conf.default.size;
      }
    }
  }),
  provide: function provide() {
    return {
      $xegrid: this
    };
  },
  data: function data() {
    return {
      tableLoading: false,
      isZMax: false,
      tableData: [],
      pendingRecords: [],
      filterData: [],
      formData: {},
      sortData: [],
      tZindex: 0,
      tablePage: {
        total: 0,
        pageSize: 10,
        currentPage: 1
      }
    };
  },
  computed: {
    isMsg: function isMsg() {
      return this.proxyOpts.message !== false;
    },
    proxyOpts: function proxyOpts() {
      return Object.assign({}, _conf.default.grid.proxyConfig, this.proxyConfig);
    },
    pagerOpts: function pagerOpts() {
      return Object.assign({}, _conf.default.grid.pagerConfig, this.pagerConfig);
    },
    formOpts: function formOpts() {
      return Object.assign({}, _conf.default.grid.formConfig, this.formConfig);
    },
    toolbarOpts: function toolbarOpts() {
      return Object.assign({}, _conf.default.grid.toolbarConfig, this.toolbarConfig || this.toolbar);
    },
    zoomOpts: function zoomOpts() {
      return Object.assign({}, _conf.default.grid.zoomConfig, this.zoomConfig);
    },
    renderStyle: function renderStyle() {
      return this.isZMax ? {
        zIndex: this.tZindex
      } : null;
    },
    tableExtendProps: function tableExtendProps() {
      var _this = this;

      var rest = {};
      propKeys.forEach(function (key) {
        rest[key] = _this[key];
      });
      return rest;
    },
    tableProps: function tableProps() {
      var isZMax = this.isZMax,
          seqConfig = this.seqConfig,
          pagerConfig = this.pagerConfig,
          loading = this.loading,
          editConfig = this.editConfig,
          proxyConfig = this.proxyConfig,
          proxyOpts = this.proxyOpts,
          tableExtendProps = this.tableExtendProps,
          tableLoading = this.tableLoading,
          tablePage = this.tablePage,
          tableData = this.tableData;
      var tableProps = Object.assign({}, tableExtendProps);

      if (isZMax) {
        if (tableExtendProps.maxHeight) {
          tableProps.maxHeight = 'auto';
        } else {
          tableProps.height = 'auto';
        }
      }

      if (proxyConfig) {
        tableProps.loading = loading || tableLoading;
        tableProps.data = tableData;
        tableProps.rowClassName = this.handleRowClassName;

        if ((proxyOpts.seq || proxyOpts.index) && (0, _tools.isEnableConf)(pagerConfig)) {
          tableProps.seqConfig = Object.assign({}, seqConfig, {
            startIndex: (tablePage.currentPage - 1) * tablePage.pageSize
          });
        }
      }

      if (editConfig) {
        tableProps.editConfig = Object.assign({}, editConfig, {
          activeMethod: this.handleActiveMethod
        });
      }

      return tableProps;
    },
    pagerProps: function pagerProps() {
      return Object.assign({}, this.pagerOpts, this.proxyConfig ? this.tablePage : {});
    }
  },
  watch: {
    columns: function columns(value) {
      var _this2 = this;

      this.$nextTick(function () {
        return _this2.loadColumn(value);
      });
    },
    toolbar: function toolbar(value) {
      if (value) {
        this.initToolbar();
      }
    },
    toolbarConfig: function toolbarConfig(value) {
      if (value) {
        this.initToolbar();
      }
    },
    proxyConfig: function proxyConfig() {
      this.initProxy();
    },
    pagerConfig: function pagerConfig() {
      this.initPages();
    }
  },
  created: function created() {
    var data = this.data,
        formOpts = this.formOpts,
        proxyOpts = this.proxyOpts,
        proxyConfig = this.proxyConfig;

    if (proxyConfig && (data || proxyOpts.form && formOpts.data)) {
      console.error('[vxe-grid] There is a conflict between the props proxy-config and data.');
    }

    if (process.env.VUE_APP_VXE_TABLE_ENV === 'development') {
      if (this.toolbar) {
        _tools.UtilTools.warn('vxe.error.delProp', ['grid.toolbar', 'grid.toolbar-config']);
      }

      if (this.toolbarConfig && !_ctor.default.isObject(this.toolbarConfig)) {
        _tools.UtilTools.warn('vxe.error.errProp', ["grid.toolbar-config=".concat(this.toolbarConfig), 'grid.toolbar-config={}']);
      }
    }

    _tools.GlobalEvent.on(this, 'keydown', this.handleGlobalKeydownEvent);
  },
  mounted: function mounted() {
    if (this.columns && this.columns.length) {
      this.loadColumn(this.columns);
    }

    this.initToolbar();
    this.initPages();
    this.initProxy();
  },
  destroyed: function destroyed() {
    _tools.GlobalEvent.off(this, 'keydown');
  },
  render: function render(h) {
    var _ref;

    var $scopedSlots = this.$scopedSlots,
        vSize = this.vSize,
        isZMax = this.isZMax;
    var hasForm = !!($scopedSlots.form || (0, _tools.isEnableConf)(this.formConfig));
    var hasToolbar = !!($scopedSlots.toolbar || (0, _tools.isEnableConf)(this.toolbarConfig) || this.toolbar);
    var hasPager = !!($scopedSlots.pager || (0, _tools.isEnableConf)(this.pagerConfig));
    return h('div', {
      class: ['vxe-grid', (_ref = {}, _defineProperty(_ref, "size--".concat(vSize), vSize), _defineProperty(_ref, 't--animat', !!this.animat), _defineProperty(_ref, 'is--round', this.round), _defineProperty(_ref, 'is--maximize', isZMax), _defineProperty(_ref, 'is--loading', this.loading || this.tableLoading), _ref)],
      style: this.renderStyle
    }, [
    /**
     * 渲染表单
     */
    hasForm ? h('div', {
      ref: 'formWrapper',
      class: 'vxe-grid--form-wrapper'
    }, $scopedSlots.form ? $scopedSlots.form.call(this, {
      $grid: this
    }, h) : renderDefaultForm(h, this)) : null,
    /**
     * 渲染工具栏
     */
    hasToolbar ? h('div', {
      ref: 'toolbarWrapper',
      class: 'vxe-grid--toolbar-wrapper'
    }, $scopedSlots.toolbar ? $scopedSlots.toolbar.call(this, {
      $grid: this
    }, h) : [h('vxe-toolbar', {
      props: this.toolbarOpts,
      ref: 'xToolbar',
      scopedSlots: getToolbarSlots(this)
    })]) : null,
    /**
     * 渲染表格顶部区域
     */
    $scopedSlots.top ? h('div', {
      ref: 'topWrapper',
      class: 'vxe-grid--top-wrapper'
    }, $scopedSlots.top.call(this, {
      $grid: this
    }, h)) : null,
    /**
     * 渲染表格
     */
    h('vxe-table', {
      props: this.tableProps,
      on: getTableOns(this),
      scopedSlots: $scopedSlots,
      ref: 'xTable'
    }),
    /**
     * 渲染表格底部区域
     */
    $scopedSlots.bottom ? h('div', {
      ref: 'bottomWrapper',
      class: 'vxe-grid--bottom-wrapper'
    }, $scopedSlots.bottom.call(this, {
      $grid: this
    }, h)) : null,
    /**
     * 渲染分页
     */
    hasPager ? h('div', {
      ref: 'pagerWrapper',
      class: 'vxe-grid--pager-wrapper'
    }, $scopedSlots.pager ? $scopedSlots.pager.call(this, {
      $grid: this
    }, h) : [h('vxe-pager', {
      props: this.pagerProps,
      on: {
        'page-change': this.pageChangeEvent
      },
      scopedSlots: getPagerSlots(this)
    })]) : null]);
  },
  methods: _objectSpread(_objectSpread({}, methods), {}, {
    callSlot: function callSlot(slotFunc, params, h, vNodes) {
      if (slotFunc) {
        var $scopedSlots = this.$scopedSlots;

        if (_ctor.default.isString(slotFunc)) {
          slotFunc = $scopedSlots[slotFunc] || null;
        }

        if (_ctor.default.isFunction(slotFunc)) {
          return slotFunc.call(this, params, h, vNodes);
        }
      }

      return [];
    },
    getParentHeight: function getParentHeight() {
      return (this.isZMax ? _tools.DomTools.getDomNode().visibleHeight : this.$el.parentNode.clientHeight) - this.getExcludeHeight();
    },

    /**
     * 获取需要排除的高度
     */
    getExcludeHeight: function getExcludeHeight() {
      var $refs = this.$refs,
          $el = this.$el,
          isZMax = this.isZMax,
          height = this.height;
      var formWrapper = $refs.formWrapper,
          toolbarWrapper = $refs.toolbarWrapper,
          topWrapper = $refs.topWrapper,
          bottomWrapper = $refs.bottomWrapper,
          pagerWrapper = $refs.pagerWrapper;
      var parentPaddingSize = isZMax || height !== 'auto' ? 0 : getPaddingTopBottomSize($el.parentNode);
      return parentPaddingSize + getPaddingTopBottomSize($el) + getOffsetHeight(formWrapper) + getOffsetHeight(toolbarWrapper) + getOffsetHeight(topWrapper) + getOffsetHeight(bottomWrapper) + getOffsetHeight(pagerWrapper);
    },
    handleRowClassName: function handleRowClassName(params) {
      var rowClassName = this.rowClassName;
      var clss = [];

      if (this.pendingRecords.some(function (item) {
        return item === params.row;
      })) {
        clss.push('row--pending');
      }

      return clss.push(rowClassName ? _ctor.default.isFunction(rowClassName) ? rowClassName(params) : rowClassName : '');
    },
    handleActiveMethod: function handleActiveMethod(params) {
      var editConfig = this.editConfig;
      var activeMethod = editConfig ? editConfig.activeMethod : null;
      return this.pendingRecords.indexOf(params.row) === -1 && (!activeMethod || activeMethod(params));
    },
    initToolbar: function initToolbar() {
      var _this3 = this;

      this.$nextTick(function () {
        var _this3$$refs = _this3.$refs,
            xTable = _this3$$refs.xTable,
            xToolbar = _this3$$refs.xToolbar;

        if (xTable && xToolbar) {
          xTable.connect(xToolbar);
        }
      });
    },
    initPages: function initPages() {
      var tablePage = this.tablePage,
          pagerConfig = this.pagerConfig,
          pagerOpts = this.pagerOpts;
      var currentPage = pagerOpts.currentPage,
          pageSize = pagerOpts.pageSize;

      if (pagerConfig) {
        if (currentPage) {
          tablePage.currentPage = currentPage;
        }

        if (pageSize) {
          tablePage.pageSize = pageSize;
        }
      }
    },
    initProxy: function initProxy() {
      var _this4 = this;

      var proxyInited = this.proxyInited,
          proxyConfig = this.proxyConfig,
          proxyOpts = this.proxyOpts,
          formConfig = this.formConfig,
          formOpts = this.formOpts;

      if (proxyConfig) {
        if ((0, _tools.isEnableConf)(formConfig) && proxyOpts.form && formOpts.items) {
          var formData = {};
          formOpts.items.forEach(function (_ref2) {
            var field = _ref2.field,
                itemRender = _ref2.itemRender;

            if (field) {
              formData[field] = itemRender && !_ctor.default.isUndefined(itemRender.defaultValue) ? itemRender.defaultValue : undefined;
            }
          });
          this.formData = formData;
        }

        if (!proxyInited && proxyOpts.autoLoad !== false) {
          this.proxyInited = true;
          this.$nextTick(function () {
            return _this4.commitProxy('init');
          });
        }
      }
    },
    handleGlobalKeydownEvent: function handleGlobalKeydownEvent(evnt) {
      var isEsc = evnt.keyCode === 27;

      if (isEsc && this.isZMax && this.zoomOpts.escRestore !== false) {
        this.triggerZoomEvent(evnt);
      }
    },

    /**
     * 提交指令，支持 code 或 button
     * @param {String/Object} code 字符串或对象
     */
    commitProxy: function commitProxy(proxyTarget) {
      var _this5 = this;

      var $refs = this.$refs,
          toolbar = this.toolbar,
          toolbarConfig = this.toolbarConfig,
          toolbarOpts = this.toolbarOpts,
          proxyOpts = this.proxyOpts,
          tablePage = this.tablePage,
          pagerConfig = this.pagerConfig,
          sortData = this.sortData,
          filterData = this.filterData,
          formData = this.formData,
          isMsg = this.isMsg;
      var beforeQuery = proxyOpts.beforeQuery,
          afterQuery = proxyOpts.afterQuery,
          beforeDelete = proxyOpts.beforeDelete,
          afterDelete = proxyOpts.afterDelete,
          beforeSave = proxyOpts.beforeSave,
          afterSave = proxyOpts.afterSave,
          _proxyOpts$ajax = proxyOpts.ajax,
          ajax = _proxyOpts$ajax === void 0 ? {} : _proxyOpts$ajax,
          _proxyOpts$props = proxyOpts.props,
          proxyProps = _proxyOpts$props === void 0 ? {} : _proxyOpts$props;
      var $xetable = $refs.xTable;
      var button;
      var code;

      if (_ctor.default.isString(proxyTarget)) {
        var matchObj = toolbarConfig || toolbar ? _ctor.default.findTree(toolbarOpts.buttons, function (item) {
          return item.code === proxyTarget;
        }, {
          children: 'dropdowns'
        }) : null;
        code = proxyTarget;
        button = matchObj ? matchObj.item : null;
      } else {
        button = proxyTarget;
        code = button.code;
      }

      var btnParams = button ? button.params : null;

      for (var _len2 = arguments.length, args = new Array(_len2 > 1 ? _len2 - 1 : 0), _key2 = 1; _key2 < _len2; _key2++) {
        args[_key2 - 1] = arguments[_key2];
      }

      switch (code) {
        case 'insert':
          this.insert();
          break;

        case 'insert_actived':
          this.insert().then(function (_ref3) {
            var row = _ref3.row;
            return _this5.setActiveRow(row);
          });
          break;

        case 'mark_cancel':
          this.triggerPendingEvent(code);
          break;

        case 'remove':
          return this.handleDeleteRow(code, 'vxe.grid.removeSelectRecord', function () {
            return _this5.removeCheckboxRow();
          });

        case 'import':
          this.importData(btnParams);
          break;

        case 'open_import':
          this.openImport(btnParams);
          break;

        case 'export':
          this.exportData(btnParams);
          break;

        case 'open_export':
          this.openExport(btnParams);
          break;

        case 'reset_custom':
          this.resetColumn(true);
          break;

        case 'init':
        case 'reload':
        case 'query':
          {
            var isInited = code === 'init';
            var isReload = code === 'reload';
            var ajaxMethods = ajax.query;

            if (ajaxMethods) {
              var params = {
                code: code,
                button: button,
                $grid: this,
                sort: sortData.length ? sortData[0] : {},
                sorts: sortData,
                filters: filterData,
                form: formData,
                options: ajaxMethods
              };

              if (pagerConfig) {
                if (isReload) {
                  tablePage.currentPage = 1;
                }

                if ((0, _tools.isEnableConf)(pagerConfig)) {
                  params.page = tablePage;
                }
              }

              if (isInited || isReload) {
                var checkedFilters = isInited ? this.getCheckedFilters() : [];
                var defaultSort = $xetable.sortOpts.defaultSort;
                var sortParams = []; // 如果使用默认排序

                if (defaultSort) {
                  if (!_ctor.default.isArray(defaultSort)) {
                    defaultSort = [defaultSort];
                  }

                  sortParams = defaultSort.map(function (item) {
                    return {
                      property: item.field,
                      order: item.order
                    };
                  });
                }

                this.sortData = params.sorts = sortParams;
                this.filterData = params.filters = isInited ? checkedFilters : [];
                this.pendingRecords = [];
                params.sort = params.sorts.length ? params.sorts[0] : {};
                this.$nextTick(function () {
                  if (isInited) {
                    (0, _util.clearTableDefaultStatus)($xetable);
                  } else {
                    (0, _util.clearTableAllStatus)($xetable);
                  }
                });
              }

              var applyArgs = [params].concat(args);
              this.tableLoading = true;
              return Promise.resolve((beforeQuery || ajaxMethods).apply(void 0, _toConsumableArray(applyArgs))).catch(function (e) {
                return e;
              }).then(function (rest) {
                _this5.tableLoading = false;

                if (rest) {
                  if ((0, _tools.isEnableConf)(pagerConfig)) {
                    tablePage.total = _ctor.default.get(rest, proxyProps.total || 'page.total') || 0;
                    _this5.tableData = _ctor.default.get(rest, proxyProps.result || 'result') || [];
                  } else {
                    _this5.tableData = (proxyProps.list ? _ctor.default.get(rest, proxyProps.list) : rest) || [];
                  }
                } else {
                  _this5.tableData = [];
                }

                if (afterQuery) {
                  afterQuery.apply(void 0, _toConsumableArray(applyArgs));
                }
              });
            } else {
              _tools.UtilTools.error('vxe.error.notFunc', ['query']);
            }

            break;
          }

        case 'delete':
          {
            var _ajaxMethods = ajax.delete;

            if (_ajaxMethods) {
              var removeRecords = this.getCheckboxRecords();
              var body = {
                removeRecords: removeRecords
              };

              var _applyArgs = [{
                $grid: this,
                code: code,
                button: button,
                body: body,
                options: _ajaxMethods
              }].concat(args);

              if (removeRecords.length) {
                return this.handleDeleteRow(code, 'vxe.grid.deleteSelectRecord', function () {
                  _this5.tableLoading = true;
                  return Promise.resolve((beforeDelete || _ajaxMethods).apply(void 0, _toConsumableArray(_applyArgs))).then(function (rest) {
                    _this5.tableLoading = false;
                    _this5.pendingRecords = _this5.pendingRecords.filter(function (row) {
                      return removeRecords.indexOf(row) === -1;
                    });

                    if (isMsg) {
                      _vXETable.default.modal.message({
                        message: _this5.getRespMsg(rest, 'vxe.grid.delSuccess'),
                        status: 'success'
                      });
                    }

                    if (afterDelete) {
                      afterDelete.apply(void 0, _toConsumableArray(_applyArgs));
                    } else {
                      _this5.commitProxy('query');
                    }
                  }).catch(function (rest) {
                    _this5.tableLoading = false;

                    if (isMsg) {
                      _vXETable.default.modal.message({
                        id: code,
                        message: _this5.getRespMsg(rest, 'vxe.grid.operError'),
                        status: 'error'
                      });
                    }
                  });
                });
              } else {
                if (isMsg) {
                  _vXETable.default.modal.message({
                    id: code,
                    message: _conf.default.i18n('vxe.grid.selectOneRecord'),
                    status: 'warning'
                  });
                }
              }
            } else {
              _tools.UtilTools.error('vxe.error.notFunc', [code]);
            }

            break;
          }

        case 'save':
          {
            var _ajaxMethods2 = ajax.save;

            if (_ajaxMethods2) {
              var _body = Object.assign({
                pendingRecords: this.pendingRecords
              }, this.getRecordset());

              var insertRecords = _body.insertRecords,
                  _removeRecords = _body.removeRecords,
                  updateRecords = _body.updateRecords,
                  pendingRecords = _body.pendingRecords;

              var _applyArgs2 = [{
                $grid: this,
                code: code,
                button: button,
                body: _body,
                options: _ajaxMethods2
              }].concat(args); // 排除掉新增且标记为删除的数据


              if (insertRecords.length) {
                _body.pendingRecords = pendingRecords.filter(function (row) {
                  return insertRecords.indexOf(row) === -1;
                });
              } // 排除已标记为删除的数据


              if (pendingRecords.length) {
                _body.insertRecords = insertRecords.filter(function (row) {
                  return pendingRecords.indexOf(row) === -1;
                });
              } // 只校验新增和修改的数据


              return this.validate(_body.insertRecords.concat(updateRecords)).then(function () {
                if (_body.insertRecords.length || _removeRecords.length || updateRecords.length || _body.pendingRecords.length) {
                  _this5.tableLoading = true;
                  return Promise.resolve((beforeSave || _ajaxMethods2).apply(void 0, _toConsumableArray(_applyArgs2))).then(function (rest) {
                    _this5.tableLoading = false;
                    _this5.pendingRecords = [];

                    if (isMsg) {
                      _vXETable.default.modal.message({
                        message: _this5.getRespMsg(rest, 'vxe.grid.saveSuccess'),
                        status: 'success'
                      });
                    }

                    if (afterSave) {
                      afterSave.apply(void 0, _toConsumableArray(_applyArgs2));
                    } else {
                      _this5.commitProxy('query');
                    }
                  }).catch(function (rest) {
                    _this5.tableLoading = false;

                    if (isMsg) {
                      _vXETable.default.modal.message({
                        id: code,
                        message: _this5.getRespMsg(rest, 'vxe.grid.operError'),
                        status: 'error'
                      });
                    }
                  });
                } else {
                  if (isMsg) {
                    _vXETable.default.modal.message({
                      id: code,
                      message: _conf.default.i18n('vxe.grid.dataUnchanged'),
                      status: 'info'
                    });
                  }
                }
              }).catch(function (errMap) {
                return errMap;
              });
            } else {
              _tools.UtilTools.error('vxe.error.notFunc', [code]);
            }

            break;
          }

        default:
          {
            var btnMethod = _vXETable.default.commands.get(code);

            if (btnMethod) {
              btnMethod.apply(void 0, [{
                code: code,
                button: button,
                $grid: this,
                $table: $xetable
              }].concat(args));
            }
          }
      }

      return this.$nextTick();
    },
    getRespMsg: function getRespMsg(rest, defaultMsg) {
      var _this$proxyOpts$props = this.proxyOpts.props,
          proxyProps = _this$proxyOpts$props === void 0 ? {} : _this$proxyOpts$props;
      var msg;

      if (rest && proxyProps.message) {
        msg = _ctor.default.get(rest, proxyProps.message);
      }

      return msg || _conf.default.i18n(defaultMsg);
    },
    handleDeleteRow: function handleDeleteRow(code, alertKey, callback) {
      var selectRecords = this.getCheckboxRecords();

      if (this.isMsg) {
        if (selectRecords.length) {
          return _vXETable.default.modal.confirm({
            id: "cfm_".concat(code),
            message: _conf.default.i18n(alertKey),
            escClosable: true
          }).then(function (type) {
            if (type === 'confirm') {
              callback();
            }
          });
        } else {
          _vXETable.default.modal.message({
            id: "msg_".concat(code),
            message: _conf.default.i18n('vxe.grid.selectOneRecord'),
            status: 'warning'
          });
        }
      } else {
        if (selectRecords.length) {
          callback();
        }
      }

      return Promise.resolve();
    },
    getFormItems: function getFormItems(index) {
      var formConfig = this.formConfig,
          formOpts = this.formOpts;
      var items = (0, _tools.isEnableConf)(formConfig) && formOpts.items ? formOpts.items : [];
      return arguments.length ? items[index] : items;
    },
    getPendingRecords: function getPendingRecords() {
      return this.pendingRecords;
    },
    triggerToolbarBtnEvent: function triggerToolbarBtnEvent(button, evnt) {
      this.commitProxy(button, evnt);
      this.$emit('toolbar-button-click', {
        code: button.code,
        button: button,
        $grid: this,
        $event: evnt
      });
    },
    triggerPendingEvent: function triggerPendingEvent(code) {
      var pendingRecords = this.pendingRecords,
          isMsg = this.isMsg;
      var selectRecords = this.getCheckboxRecords();

      if (selectRecords.length) {
        var plus = [];
        var minus = [];
        selectRecords.forEach(function (data) {
          if (pendingRecords.some(function (item) {
            return data === item;
          })) {
            minus.push(data);
          } else {
            plus.push(data);
          }
        });

        if (minus.length) {
          this.pendingRecords = pendingRecords.filter(function (item) {
            return minus.indexOf(item) === -1;
          }).concat(plus);
        } else if (plus.length) {
          this.pendingRecords = pendingRecords.concat(plus);
        }

        this.clearCheckboxRow();
      } else {
        if (isMsg) {
          _vXETable.default.modal.message({
            id: code,
            message: _conf.default.i18n('vxe.grid.selectOneRecord'),
            status: 'warning'
          });
        }
      }
    },
    pageChangeEvent: function pageChangeEvent(params) {
      var proxyConfig = this.proxyConfig,
          tablePage = this.tablePage;
      var currentPage = params.currentPage,
          pageSize = params.pageSize;
      tablePage.currentPage = currentPage;
      tablePage.pageSize = pageSize;
      this.$emit('page-change', Object.assign({
        $grid: this
      }, params));

      if (proxyConfig) {
        this.commitProxy('query');
      }
    },
    sortChangeEvent: function sortChangeEvent(params) {
      var $table = params.$table,
          column = params.column,
          sortList = params.sortList;
      var isRemote = _ctor.default.isBoolean(column.remoteSort) ? column.remoteSort : $table.sortOpts.remote; // 如果是服务端排序

      if (isRemote) {
        this.sortData = sortList;

        if (this.proxyConfig) {
          this.tablePage.currentPage = 1;
          this.commitProxy('query');
        }
      }

      this.$emit('sort-change', Object.assign({
        $grid: this
      }, params));
    },
    filterChangeEvent: function filterChangeEvent(params) {
      var $table = params.$table,
          filterList = params.filterList; // 如果是服务端过滤

      if ($table.filterOpts.remote) {
        this.filterData = filterList;

        if (this.proxyConfig) {
          this.tablePage.currentPage = 1;
          this.commitProxy('query');
        }
      }

      this.$emit('filter-change', Object.assign({
        $grid: this
      }, params));
    },
    submitEvent: function submitEvent(params) {
      var proxyConfig = this.proxyConfig;

      if (proxyConfig) {
        this.commitProxy('reload');
      }

      this.$emit('form-submit', Object.assign({
        $grid: this
      }, params));
    },
    resetEvent: function resetEvent(params) {
      var proxyConfig = this.proxyConfig;

      if (proxyConfig) {
        this.commitProxy('reload');
      }

      this.$emit('form-reset', Object.assign({
        $grid: this
      }, params));
    },
    submitInvalidEvent: function submitInvalidEvent(params) {
      this.$emit('form-submit-invalid', Object.assign({
        $grid: this
      }, params));
    },
    togglCollapseEvent: function togglCollapseEvent(params) {
      var _this6 = this;

      this.$nextTick(function () {
        return _this6.recalculate(true);
      });
      this.$emit('form-toggle-collapse', Object.assign({
        $grid: this
      }, params));
    },
    triggerZoomEvent: function triggerZoomEvent(evnt) {
      this.zoom();
      this.$emit('zoom', {
        $grid: this,
        type: this.isZMax ? 'max' : 'revert',
        $event: evnt
      });
    },
    zoom: function zoom() {
      return this[this.isZMax ? 'revert' : 'maximize']();
    },
    isMaximized: function isMaximized() {
      return this.isZMax;
    },
    maximize: function maximize() {
      return this.handleZoom(true);
    },
    revert: function revert() {
      return this.handleZoom();
    },
    handleZoom: function handleZoom(isMax) {
      var _this7 = this;

      var isZMax = this.isZMax;

      if (isMax ? !isZMax : isZMax) {
        this.isZMax = !isZMax;

        if (this.tZindex < _tools.UtilTools.getLastZIndex()) {
          this.tZindex = _tools.UtilTools.nextZIndex();
        }
      }

      return this.$nextTick().then(function () {
        return _this7.recalculate(true);
      }).then(function () {
        return _this7.isZMax;
      });
    },
    getProxyInfo: function getProxyInfo() {
      var sortData = this.sortData;
      return this.proxyConfig ? {
        data: this.tableData,
        filter: this.filterData,
        form: this.formData,
        sort: sortData.length ? sortData[0] : {},
        sorts: sortData,
        pager: this.tablePage,
        pendingRecords: this.pendingRecords
      } : null;
    }
  }, process.env.VUE_APP_VXE_TABLE_ENV === 'development' ? {
    loadColumn: function loadColumn(columns) {
      var $scopedSlots = this.$scopedSlots;

      _ctor.default.eachTree(columns, function (column) {
        if (column.slots) {
          _ctor.default.each(column.slots, function (func) {
            if (!_ctor.default.isFunction(func)) {
              if (!$scopedSlots[func]) {
                _tools.UtilTools.error('vxe.error.notSlot', [func]);
              }
            }
          });
        }
      });

      return this.$refs.xTable.loadColumn(columns);
    },
    reloadColumn: function reloadColumn(columns) {
      this.clearAll();
      return this.loadColumn(columns);
    }
  } : null)
};
exports.default = _default2;