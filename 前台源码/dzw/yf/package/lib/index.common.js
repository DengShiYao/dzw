const VXETableExport = process.env.NODE_ENV === 'production' ? require('./index.common.pro.js') : require('./index.common.dev.js')
VXETableExport.VXETable = VXETableExport
module.exports = VXETableExport
