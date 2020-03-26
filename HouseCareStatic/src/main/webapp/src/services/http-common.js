import axios from "axios";

export default axios.create({
  baseURL: "http://localhost/",
  headers: {
    "Content-type": "application/json",
    'user-token': 'cd3b3834-283b-4727-9a80-d8b9cdc5a253'
  }
});