import axios from "axios"

const user = JSON.parse(localStorage.getItem('user')) || []; 
const uuid = user.sessao.uuid || '';

export default axios.create({
  baseURL: "http://localhost/",
  headers: {
    "Content-type": "application/json",
    'user-token': uuid
  }
});
