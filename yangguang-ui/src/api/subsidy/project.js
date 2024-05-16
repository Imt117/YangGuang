import request from '@/utils/request'

// 查询补贴项目列表
export function listProject(query) {
  return request({
    url: '/subsidy/project/list',
    method: 'get',
    params: query
  })
}

// 查询补贴项目详细
export function getProject(projectId) {
  return request({
    url: '/subsidy/project/' + projectId,
    method: 'get'
  })
}

// 新增补贴项目
export function addProject(data) {
  return request({
    url: '/subsidy/project',
    method: 'post',
    data: data
  })
}

// 修改补贴项目
export function updateProject(data) {
  return request({
    url: '/subsidy/project',
    method: 'put',
    data: data
  })
}

// 删除补贴项目
export function delProject(projectId) {
  return request({
    url: '/subsidy/project/' + projectId,
    method: 'delete'
  })
}
