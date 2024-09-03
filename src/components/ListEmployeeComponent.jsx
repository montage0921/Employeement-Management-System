import React from "react";

export const ListEmployeeComponent = () => {
  const dummyData = [
    {
      id: 1,
      firstName: "Gary",
      lastName: "Shi",
      email: "garyshi0921@gmail.com",
    },
    {
      id: 2,
      firstName: "Jie",
      lastName: "Shi",
      email: "154600695@qq.com",
    },
    {
      id: 3,
      firstName: "WenHui",
      lastName: "Ruan",
      email: "sjrwhst@163.com",
    },
  ];

  return (
    <div className="container">
      <h2 class="text-center">List of Employees</h2>
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
          </tr>
        </thead>
        <tbody>
          {dummyData.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
