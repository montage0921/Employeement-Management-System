import axios from "axios";

// set the base url for getting method
const REST_API_BASE_URL = "http://localhost:8080/api/employees";

// axios.get() returns a promise
export const listEmployees = () => {
  return axios.get(REST_API_BASE_URL);
};

export const addEmployee = (employee) =>
  axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId) => {
  return axios.get(REST_API_BASE_URL + "/" + employeeId);
};

export const updateEmployee = (employeeId, employee) => {
  return axios.put(REST_API_BASE_URL + "/" + employeeId, employee);
};
