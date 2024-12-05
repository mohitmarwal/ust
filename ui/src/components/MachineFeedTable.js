import React, { useEffect, useState } from 'react';
import { fetchMachineFeeds } from '../services/api';

const MachineFeedTable = ({ machineId }) => {
  const [feeds, setFeeds] = useState([]);
  const [machine, setMachine] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const loadFeeds = async () => {
      try {
        const data = await fetchMachineFeeds(machineId);
        setMachine(data.machine);
        setFeeds(data.feeds);
      } catch (err) {
        setError('Failed to load machine feeds');
      } finally {
        setLoading(false);
      }
    };

    loadFeeds();
  }, [machineId]);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div>
      <h2>Machine Details</h2>
      <p><strong>ID:</strong> {machine.id}</p>
      <p><strong>Name:</strong> {machine.data?.name}</p>

      <h2>Machine Feeds</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Type</th>
            <th>Timestamp</th>
            <th>Data</th>
          </tr>
        </thead>
        <tbody>
          {feeds.map((feed, index) => (
            <tr key={index}>
              <td>{feed.type}</td>
              <td>{feed.timestamp}</td>
              <td>{JSON.stringify(feed.data)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MachineFeedTable;