try (BufferedReader br = new BufferedReader(new FileReader("resources/data.txt"))) {
  String line;
  int i = 1;
  while ((line = br.readLine()) != null) {
      if (line.matches("[a-z]{4}")) {
          wordleDatabaseConnection.addValidWord(i, line);
          logger.info("Valid word added from data.txt: " + line);
          i++;
      } else {
          logger.warning("Invalid word in data.txt: " + line);
      }
  }
} catch (IOException e) {
  System.out.println("Failed to load required resources. Please contact support.");
  logger.log(Level.SEVERE, "Error reading data.txt", e);
  return;
}
