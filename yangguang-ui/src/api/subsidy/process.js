import request from '@/utils/request'

// 查询项目流程配置列表
export function listProcess(query) {
  return request({
    url: '/subsidy/process/list',
    method: 'get',
    params: query
  })
}

// 查询项目流程配置详细
export function getProcess(processId) {
  return request({
    url: '/subsidy/process/' + processId,
    method: 'get'
  })
}

// 新增项目流程配置
export function addProcess(data) {
  return request({
    url: '/subsidy/process',
    method: 'post',
    data: data
  })
}

// 修改项目流程配置
export function updateProcess(data) {
  return request({
    url: '/subsidy/process',
    method: 'put',
    data: data
  })
}

// 删除项目流程配置
export function delProcess(processId) {
  return request({
    url: '/subsidy/process/' + processId,
    method: 'delete'
  })
}
