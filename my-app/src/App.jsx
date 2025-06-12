import { useState } from 'react'
import { FaIdBadge, FaUser, FaUserTag } from 'react-icons/fa'
import './App.css'

function App() {
  const [formData, setFormData] = useState({
    id: '',
    name: '',
    surname: ''
  });
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch('http://localhost:8080/rohit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formData)
    })
      .then((res) => res.json())
      .then((data) => {
        console.log('API Response:', data);
        alert('Data submitted successfully!');
      })
      .catch((err) => {
        console.error('Error:', err);
        alert('Failed to submit data');
      });
  };

  const fetchUsers = () => {
    setLoading(true);
    fetch('http://localhost:8080/rohit') // Adjust endpoint if needed
      .then(res => res.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      })
      .catch(err => {
        alert('Failed to fetch users');
        setLoading(false);
      });
  };

  return (
    <div className="container" style={{
      maxWidth: 400,
      margin: '40px auto',
      background: '#fff',
      borderRadius: 12,
      boxShadow: '0 4px 24px rgba(0,0,0,0.08)',
      padding: 32
    }}>
      <h2 style={{ marginBottom: 24, color: '#333', letterSpacing: 1 }}>Add User</h2>
      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <FaIdBadge className="input-icon" />
          <input
            type="text"
            name="id"
            value={formData.id}
            onChange={handleChange}
            placeholder="User ID"
            required
            autoComplete="off"
          />
        </div>
        <div className="input-group">
          <FaUser className="input-icon" />
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="First Name"
            required
            autoComplete="off"
          />
        </div>
        <div className="input-group">
          <FaUserTag className="input-icon" />
          <input
            type="text"
            name="surname"
            value={formData.surname}
            onChange={handleChange}
            placeholder="Surname"
            required
            autoComplete="off"
          />
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>

      <button
        className="fetch-btn"
        style={{ marginTop: 20, marginBottom: 20, width: '100%' }}
        onClick={fetchUsers}
        disabled={loading}
      >
        {loading ? 'Loading...' : 'Fetch All Users'}
      </button>

      {users.length > 0 && (
        <div style={{ width: '100%', overflowX: 'auto' }}>
          <table className="user-table">
            <thead>
              <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Surname</th>
              </tr>
            </thead>
            <tbody>
              {users.map((u, idx) => (
                <tr key={u.id || idx}>
                  <td>{u.id}</td>
                  <td>{u.name}</td>
                  <td>{u.surname}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default App