import axios from 'axios'

const DEPARTMENT_REST_API_BASE_URL = 'http://localhost:8081/api/department'

export const getAllDepartments = () => {
    return axios.get(DEPARTMENT_REST_API_BASE_URL)
      .then(response => {
        console.log(response.data);
        return response.data;
      })
      .catch(error => {
        console.error(error);
        throw error;
      });
  };

export const createDepartment = (department) => axios.post(DEPARTMENT_REST_API_BASE_URL, department);

export const getDepartmentById = (departmentId) => axios.get(DEPARTMENT_REST_API_BASE_URL + '/' + departmentId);

export const updateDepartment = (departmentId, department) => axios.put(DEPARTMENT_REST_API_BASE_URL + '/' + departmentId, department);

export const deleteDepartment = (departmentId) => axios.delete(DEPARTMENT_REST_API_BASE_URL + '/' + departmentId);

