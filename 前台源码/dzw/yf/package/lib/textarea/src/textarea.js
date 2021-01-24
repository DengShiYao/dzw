"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _ctor = _interopRequireDefault(require("xe-utils/ctor"));

var _conf = _interopRequireDefault(require("../../conf"));

var _size = _interopRequireDefault(require("../../mixins/size"));

var _tools = require("../../tools");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

var autoTxtElem;
var _default2 = {
  name: 'VxeTextarea',
  mixins: [_size.default],
  model: {
    prop: 'value',
    event: 'modelValue'
  },
  props: {
    value: [String, Number],
    immediate: {
      type: Boolean,
      default: true
    },
    name: String,
    readonly: Boolean,
    disabled: Boolean,
    placeholder: String,
    maxlength: [String, Number],
    rows: {
      type: [String, Number],
      default: 2
    },
    showWordCount: Boolean,
    autosize: [Boolean, Object],
    form: String,
    resize: {
      type: String,
      default: function _default() {
        return _conf.default.textarea.resize;
      }
    },
    size: {
      type: String,
      default: function _default() {
        return _conf.default.textarea.size || _conf.default.size;
      }
    }
  },
  data: function data() {
    return {
      inputValue: this.value
    };
  },
  computed: {
    inputCount: function inputCount() {
      return _ctor.default.getSize(this.inputValue);
    },
    isCountError: function isCountError() {
      return this.maxlength && this.inputCount > _ctor.default.toNumber(this.maxlength);
    },
    defaultEvents: function defaultEvents() {
      var _this = this;

      var evnts = {};

      _ctor.default.each(this.$listeners, function (cb, name) {
        if (['input', 'change', 'blur'].indexOf(name) === -1) {
          evnts[name] = _this.triggerEvent;
        }
      });

      evnts.input = this.inputEvent;
      evnts.change = this.changeEvent;
      evnts.blur = this.blurEvent;
      return evnts;
    },
    sizeOpts: function sizeOpts() {
      return Object.assign({
        minRows: 1,
        maxRows: 10
      }, _conf.default.textarea.autosize, this.autosize);
    }
  },
  watch: {
    value: function value(val) {
      this.inputValue = val;
      this.updateAutoTxt();
    }
  },
  mounted: function mounted() {
    var inputValue = this.inputValue;

    if (inputValue) {
      this.updateAutoTxt();
      this.handleResize();
    }
  },
  render: function render(h) {
    var _ref;

    var defaultEvents = this.defaultEvents,
        inputValue = this.inputValue,
        vSize = this.vSize,
        name = this.name,
        form = this.form,
        resize = this.resize,
        placeholder = this.placeholder,
        readonly = this.readonly,
        disabled = this.disabled,
        maxlength = this.maxlength,
        autosize = this.autosize,
        showWordCount = this.showWordCount;
    var attrs = {
      name: name,
      form: form,
      placeholder: placeholder,
      maxlength: maxlength,
      readonly: readonly,
      disabled: disabled
    };

    if (placeholder) {
      attrs.placeholder = _tools.UtilTools.getFuncText(placeholder);
    }

    return h('div', {
      class: ['vxe-textarea', (_ref = {}, _defineProperty(_ref, "size--".concat(vSize), vSize), _defineProperty(_ref, 'is--autosize', autosize), _defineProperty(_ref, 'is--disabled', disabled), _ref)]
    }, [h('textarea', {
      ref: 'textarea',
      class: 'vxe-textarea--inner',
      domProps: {
        value: inputValue
      },
      attrs: attrs,
      style: resize ? {
        resize: resize
      } : null,
      on: defaultEvents
    }), showWordCount ? h('span', {
      class: ['vxe-textarea--count', {
        'is--error': this.isCountError
      }]
    }, "".concat(this.inputCount).concat(maxlength ? "/".concat(maxlength) : '')) : null]);
  },
  methods: {
    focus: function focus() {
      this.$refs.textarea.focus();
      return this.$nextTick();
    },
    blur: function blur() {
      this.$refs.textarea.blur();
      return this.$nextTick();
    },
    triggerEvent: function triggerEvent(evnt) {
      var inputValue = this.inputValue;
      this.$emit(evnt.type, {
        value: inputValue,
        $event: evnt
      });
    },
    emitUpdate: function emitUpdate(value, evnt) {
      this.inputValue = value;
      this.$emit('modelValue', value);

      if (this.value !== value) {
        this.$emit('change', {
          value: value,
          $event: evnt
        });
      }
    },
    inputEvent: function inputEvent(evnt) {
      var immediate = this.immediate;
      var value = evnt.target.value;
      this.inputValue = value;

      if (immediate) {
        this.emitUpdate(value, evnt);
      }

      this.handleResize();
      this.triggerEvent(evnt);
    },
    changeEvent: function changeEvent(evnt) {
      var immediate = this.immediate;

      if (immediate) {
        this.triggerEvent(evnt);
      } else {
        this.emitUpdate(this.inputValue, evnt);
      }
    },
    blurEvent: function blurEvent(evnt) {
      var inputValue = this.inputValue,
          immediate = this.immediate;

      if (!immediate) {
        this.emitUpdate(inputValue, evnt);
      }

      this.$emit('blur', {
        value: inputValue,
        $event: evnt
      });
    },
    updateAutoTxt: function updateAutoTxt() {
      var $refs = this.$refs,
          inputValue = this.inputValue,
          size = this.size,
          autosize = this.autosize;

      if (autosize) {
        if (!autoTxtElem) {
          autoTxtElem = document.createElement('div');
        }

        if (!autoTxtElem.parentNode) {
          document.body.appendChild(autoTxtElem);
        }

        var textElem = $refs.textarea;
        var textStyle = getComputedStyle(textElem);
        autoTxtElem.className = ['vxe-textarea--autosize', size ? "size--".concat(size) : ''].join(' ');
        autoTxtElem.style.width = "".concat(textElem.clientWidth, "px");
        autoTxtElem.style.padding = textStyle.padding;
        autoTxtElem.innerHTML = ('' + (inputValue || '　')).replace(/\n$/, '\n　');
      }
    },
    handleResize: function handleResize() {
      var _this2 = this;

      if (this.autosize) {
        this.$nextTick(function () {
          var $refs = _this2.$refs,
              sizeOpts = _this2.sizeOpts;
          var minRows = sizeOpts.minRows,
              maxRows = sizeOpts.maxRows;
          var textElem = $refs.textarea;
          var sizeHeight = autoTxtElem.clientHeight;
          var textStyle = getComputedStyle(textElem);

          var lineHeight = _ctor.default.toNumber(textStyle.lineHeight);

          var paddingTop = _ctor.default.toNumber(textStyle.paddingTop);

          var paddingBottom = _ctor.default.toNumber(textStyle.paddingBottom);

          var borderTopWidth = _ctor.default.toNumber(textStyle.borderTopWidth);

          var borderBottomWidth = _ctor.default.toNumber(textStyle.borderBottomWidth);

          var intervalHeight = paddingTop + paddingBottom + borderTopWidth + borderBottomWidth;
          var rowNum = (sizeHeight - intervalHeight) / lineHeight;
          var textRows = rowNum && /[0-9]/.test(rowNum) ? rowNum : Math.floor(rowNum) + 1;
          var vaildRows = textRows;

          if (textRows < minRows) {
            vaildRows = minRows;
          } else if (textRows > maxRows) {
            vaildRows = maxRows;
          }

          textElem.style.height = "".concat(vaildRows * lineHeight + intervalHeight, "px");
        });
      }
    }
  }
};
exports.default = _default2;