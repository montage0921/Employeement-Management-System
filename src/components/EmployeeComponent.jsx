import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { addEmployee } from "../services/EmployeeService";

export const EmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const navigate = useNavigate();

  function saveEmployee(e) {
    e.preventDefault();
    const employee = { firstName, lastName, email };
    addEmployee(employee).then((response) => {
      console.log(response.data);
      navigate("/employees");
    });
  }

  return (
    <>
      <div className="container">
        <br></br>
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center mt-3">Add Employee</h2>
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">First Name</label>
                <input
                  type="text"
                  placeholder="Enter first name"
                  name="firstName"
                  value={firstName}
                  className="form-control"
                  onChange={(e) => setFirstName(e.target.value)}
                ></input>
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Last Name</label>
                <input
                  type="text"
                  placeholder="Enter last name"
                  name="lastName"
                  value={lastName}
                  className="form-control"
                  onChange={(e) => setLastName(e.target.value)}
                ></input>
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Email</label>
                <input
                  type="text"
                  placeholder="Enter last name"
                  name="email"
                  value={email}
                  className="form-control"
                  onChange={(e) => setEmail(e.target.value)}
                ></input>
              </div>
              <button className="btn btn-success" onClick={saveEmployee}>
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};
