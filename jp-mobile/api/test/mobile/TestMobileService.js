import request from "../../../common/request"

export default class TestMobileService {
  save (inputForm) {
    return request({
      url: '/test/mobile/testMobile/save',
      method: 'post',
      data: inputForm
    })
  }

  delete (ids) {
    return request({
      url: '/test/mobile/testMobile/delete',
      method: 'delete',
      params: {ids: ids}
    })
  }

  queryById (id) {
    return request({
      url: '/test/mobile/testMobile/queryById',
      method: 'get',
      params: {id: id}
    })
  }

  list (params) {
    return request({
      url: '/test/mobile/testMobile/list',
      method: 'get',
      params: params
    })
  }
}
