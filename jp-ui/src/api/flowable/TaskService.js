import request from '@/utils/httpRequest'

export default class TaskService {
  start (data) {
    return request({
      url: '/flowable/task/start',
      method: 'post',
      data: data
    })
  }

  todoList (params) {
    return request({
      url: '/flowable/task/todo',
      method: 'get',
      params: params
    })
  }

  historicList (params) {
    return request({
      url: '/flowable/task/historic',
      method: 'get',
      params: params
    })
  }

  historicTaskList (procInsId) {
    return request({
      url: '/flowable/task/historicTaskList',
      method: 'get',
      params: {procInsId: procInsId}
    })
  }

  myApplyedList (params) {
    return request({
      url: '/flowable/task/myApplyed',
      method: 'get',
      params: params
    })
  }

  getTaskDef (params) {
    return request({
      url: '/flowable/task/getTaskDef',
      method: 'get',
      params: params
    })
  }

  delegate (taskId, userId) {
    return request({
      url: `/flowable/task/delegate`,
      method: 'put',
      params: {taskId: taskId, userId: userId}
    })
  }

  callback (params) {
    return request({
      url: `/flowable/task/callback`,
      method: 'put',
      params: params
    })
  }

  audit (data) {
    return request({
      url: `/flowable/task/audit`,
      method: 'post',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8' },
      data: data
    })
  }

  backNodes (taskId) {
    return request({
      url: `/flowable/task/backNodes`,
      method: 'put',
      params: {taskId: taskId}
    })
  }

  back (params) {
    return request({
      url: `/flowable/task/back`,
      method: 'put',
      params: params
    })
  }

  transfer (taskId, userId) {
    return request({
      url: `/flowable/task/transfer`,
      method: 'put',
      params: {taskId: taskId, userId: userId}
    })
  }

  addSignTask (data) {
    return request({
      url: `/flowable/task/addSignTask`,
      method: 'post',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8' },
      data: data
    })
  }
  getFlowChart (processInstanceId) {
    return request({
      url: `/flowable/task/getFlowChart`,
      method: 'get',
      params: {processInstanceId: processInstanceId}
    })
  }

  urge (data) {
    return request({
      url: `/flowable/task/urge`,
      method: 'post',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8' },
      data: data
    })
  }
}
