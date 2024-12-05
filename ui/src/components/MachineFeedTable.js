import React, { useEffect, useState } from 'react';
import { fetchMachineFeeds } from '../services/api';

const MachineFeedTable = ({ machineId }) => {
  const [machineDetails, setMachineDetails] = useState({});
  const [combinedFeeds, setCombinedFeeds] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const loadFeeds = async () => {
      try {
        const data = await fetchMachineFeeds(machineId);
        setMachineDetails(data.machineDetails);
        setCombinedFeeds(data.combinedFeeds);
      } catch (err) {
        setError('Failed to load machine feeds');
      } finally {
        setLoading(false);
      }
    };

    loadFeeds();
  }, [machineId]);

  const determineType = (feed) => {
    return feed.data?.metrics ? 'Session' : 'Repair';
  };

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div>
      <h2>Machine Details</h2>
      <p><strong>ID:</strong> {machineDetails.id}</p>
      <p><strong>Name:</strong> {machineDetails.data?.name}</p>

      <h2>Combined Feeds</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Machine ID</th>
            <th>Timestamp</th>
            <th>Type</th>
            <th>Data</th>
          </tr>
        </thead>
        <tbody>
          {combinedFeeds.map((feed, index) => (
            <tr key={index}>
              <td>{feed.id}</td>
              <td>{feed.machine_id}</td>
              <td>{new Date(feed.created_at).toLocaleString()}</td>
              <td>{determineType(feed)}</td>
              <td>{JSON.stringify(feed.data)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MachineFeedTable;
