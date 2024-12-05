import React from 'react';
import MachineFeedTable from './components/MachineFeedTable';

const App = () => {
  const machineId = '2'; // Example machine ID, replace with a dynamic ID if needed

  return (
    <div>
      <h1>Machine Feeds Dashboard</h1>
      <MachineFeedTable machineId={machineId} />
    </div>
  );
};

export default App;