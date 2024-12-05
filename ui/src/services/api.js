import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/machine-feeds'; // Replace with your backend URL

export const fetchMachineFeeds = async (machineId) => {
  try {
    const response = await axios.get(`${API_BASE_URL}/${machineId}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching machine feeds:', error);
    throw error;
  }
};