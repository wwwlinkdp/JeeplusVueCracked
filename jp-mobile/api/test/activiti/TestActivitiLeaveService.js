import request from "../../../common/request"

export default class TestActivitiLeaveService {
  save (inputForm) {
    return request({
      url: '/test/activiti/testActivitiLeave/save',
      method: 'post',
      data: inputForm
    })
  }

  delete (ids) {
    return request({
      url: '/test/activiti/testActivitiLeave/delete',
      method: 'delete',
      params: {ids: ids}
    })
  }

  queryById (id) {
    return request({
      url: '/test/activiti/testActivitiLeave/queryById',
      method: 'get',
      params: {id: id}
    })
  }

  list (params) {
    return request({
      url: '/test/activiti/testActivitiLeave/list',
      method: 'get',
      params: params
    })
  }
}
