import { useEffect, useState } from "react";

export function useFetch(fetchFn, initialData) {
  const [isFetching, setIsFetching] = useState(false);
  const [fetchedData, setFetchedData] = useState(initialData);
  const [error, setError] = useState();

  useEffect(() => {
    async function fetchData() {
      setIsFetching(true);

      try {
        const data = await fetchFn();

        setFetchedData(data);
        setIsFetching(false);
      } catch (error) {
        setError({
          message:
            error.message || "Could not fetch data, please try again later",
        });
        setIsFetching(false);
      }
    }

    fetchData();
  }, [fetchFn]);

  return {
    isFetching,
    error,
    fetchedData,
    setFetchedData
  };
}
