import request from '@/utils/httpRequest'

export default class TestActivitiAuditService {
  save (inputForm) {
    return request({
      url: '/test/activiti/testActivitiAudit/save',
      method: 'post',
      data: inputForm
    })
  }

  delete (ids) {
    return request({
      url: '/test/activiti/testActivitiAudit/delete',
      method: 'delete',
      params: {ids: ids}
    })
  }

  queryById (id) {
    return request({
      url: '/test/activiti/testActivitiAudit/queryById',
      method: 'get',
      params: {id: id}
    })
  }

  list (params) {
    return request({
      url: '/test/activiti/testActivitiAudit/list',
      method: 'get',
      params: params
    })
  }
}
