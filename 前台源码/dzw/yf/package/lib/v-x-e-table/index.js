"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = exports.VXETable = exports.VXETableInstance = void 0;

var _ctor = _interopRequireDefault(require("xe-utils/ctor"));

var _conf = _interopRequireDefault(require("../conf"));

var _interceptor = _interopRequireDefault(require("./src/interceptor"));

var _renderer = _interopRequireDefault(require("./src/renderer"));

var _commands = _interopRequireDefault(require("./src/commands"));

var _menus = _interopRequireDefault(require("./src/menus"));

var _formats = _interopRequireDefault(require("./src/formats"));

var _setup = _interopRequireDefault(require("./src/setup"));

var _tools = require("../tools");

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var installedPlugins = [];

function use(Plugin, options) {
  /* eslint-disable @typescript-eslint/no-use-before-define */
  if (Plugin && Plugin.install) {
    if (installedPlugins.indexOf(Plugin) === -1) {
      Plugin.install(VXETableInstance, options);
      installedPlugins.push(Plugin);
    }
  }

  return VXETableInstance;
}
/**
 * 检测模块的安装顺序是否正确
 */


function reg(key) {
  /* eslint-disable @typescript-eslint/no-use-before-define */
  if (VXETableInstance.Table) {
    _tools.UtilTools.error('vxe.error.useErr', [key]);
  }

  VXETableInstance["_".concat(key)] = 1;
}

var VXETableInstance = {
  t: function t(key, args) {
    return _conf.default.i18n(key, args);
  },
  v: 'v3',
  reg: reg,
  use: use,
  setup: _setup.default,
  interceptor: _interceptor.default,
  renderer: _renderer.default,
  commands: _commands.default,
  formats: _formats.default,
  menus: _menus.default
};
/**
 * 获取当前的 zIndex
 */

exports.VXETableInstance = VXETableInstance;
Object.defineProperty(VXETableInstance, 'zIndex', {
  get: _tools.UtilTools.getLastZIndex
});
/**
 * 获取下一个 zIndex
 */

Object.defineProperty(VXETableInstance, 'nextZIndex', {
  get: _tools.UtilTools.nextZIndex
});

function getExportOrImpotType(types, flag) {
  var rest = [];

  _ctor.default.objectEach(types, function (val, type) {
    if (val === 0 || val === flag) {
      rest.push(type);
    }
  });

  return rest;
}
/**
 * 获取所有导出类型
 */


Object.defineProperty(VXETableInstance, 'exportTypes', {
  get: function get() {
    return getExportOrImpotType(_conf.default.export.types, 1);
  }
});
/**
 * 获取所有导入类型
 */

Object.defineProperty(VXETableInstance, 'importTypes', {
  get: function get() {
    return getExportOrImpotType(_conf.default.export.types, 2);
  }
});
var VXETable = VXETableInstance;
exports.VXETable = VXETable;
var _default = VXETable;
exports.default = _default;