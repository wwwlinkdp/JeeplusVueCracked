import request from '@/utils/httpRequest'

export default class UserService {
  save (inputForm) {
    return request({
      url: `/sys/user/save`,
      method: 'post',
      headers: {arrayFormat: 'repeat'},
      data: inputForm
    })
  }

  saveInfo (inputForm) {
    return request({
      url: `/sys/user/saveInfo`,
      method: 'post',
      headers: {arrayFormat: 'repeat'},
      data: inputForm
    })
  }

  savePwd (inputForm) {
    return request({
      url: `/sys/user/savePwd`,
      method: 'put',
      params: inputForm
    })
  }

  delete (ids) {
    return request({
      url: '/sys/user/delete',
      method: 'delete',
      params: {ids: ids}
    })
  }

  queryById (id) {
    return request({
      url: `/sys/user/queryById`,
      method: 'get',
      params: {id: id}
    })
  }

  info () {
    return request({
      url: `/sys/user/info`,
      method: 'get'
    })
  }

  getMenus () {
    return request({
      url: `/sys/user/getMenus`,
      method: 'get'
    })
  }

  list (params) {
    return request({
      url: '/sys/user/list',
      method: 'get',
      params: params
    })
  }
  exportTemplate () {
    return request({
      url: '/sys/user/import/template',
      method: 'get',
      responseType: 'blob'
    })
  }

  exportExcel (params) {
    return request({
      url: '/sys/user/export',
      method: 'get',
      params: params,
      responseType: 'blob'
    })
  }

  importExcel (data) {
    return request({
      url: '/sys/user/import',
      method: 'post',
      data: data
    })
  }
}
