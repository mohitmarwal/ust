const API_BASE_URL = 'http://localhost:8080/machine-feeds'; // Replace with your backend URL

export const fetchMachineFeeds = async (machineId) => {
  try {
    const response = await fetch(`${API_BASE_URL}/${machineId}`);
    if (!response.ok) {
      throw new Error(`Failed to fetch machine feeds: ${response.statusText}`);
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching machine feeds:', error);
    throw error;
  }
};