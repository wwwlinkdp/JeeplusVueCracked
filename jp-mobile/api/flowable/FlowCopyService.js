import request from "../../common/request"

export default class FlowCopyService {
  save (inputForm) {
    return request({
      url: '/extension/flowCopy/save',
      method: 'post',
      header: { 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8' },
      data: inputForm
    })
  }

  delete (ids) {
    return request({
      url: '/extension/flowCopy/delete',
      method: 'delete',
      params: {ids: ids}
    })
  }

  list (params) {
    return request({
      url: '/extension/flowCopy/list',
      method: 'get',
      params: params
    })
  }
}
