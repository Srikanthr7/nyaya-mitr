# Nyaya Mitr – Multilingual Indian Legal AI Assistant

Nyaya Mitr is an AI-powered virtual legal assistant designed to help common people understand Indian law in a simple, conversational way. It specializes in IPC (Indian Penal Code), BNS (Bharatiya Nyaya Sanhita), and CrPC (Code of Criminal Procedure), and supports multilingual voice and text interactions using LiveKit.

---

## Features

- Multilingual legal assistance (Hindi, English, Tamil, and other Indian languages)
- Voice-based interaction using LiveKit Cloud
- Context-aware responses using RAG (Retrieval Augmented Generation)
- Always includes relevant IPC, BNS, and CrPC sections
- Friendly, conversational style like a neighborhood lawyer
- Optimized for speech output
- Noise cancellation for better voice clarity

---

## Legal Capabilities

Nyaya Mitr helps users with:

- Criminal cases (murder, theft, cheating, assault)
- FIR filing and police complaints
- Arrest and bail procedures
- Domestic violence and family matters
- Basic civil disputes

Each answer includes:
- Relevant legal section references
- Simple explanation
- Practical next steps

---

## Tech Stack

- Python 3.8+
- LiveKit Cloud (real-time communication)
- Google Gemini API (LLM reasoning)
- Speech Recognition
- Text-to-Speech (TTS)
- RAG pipeline

---

## Project Structure

```
nyaya-mitr/
│
├── agent.py # Main agent logic
├── prompt.py # Instructions and response structure
├── requirements.txt # Dependencies
├── .env # API keys
```

---

## Setup Guide

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd nyaya-mitr
```

### 2. Install Requirements

```bash
pip install -r requirements.txt
```

### 3. Environment Variables

Create a .env file in the root folder:

```env
LIVEKIT_API_KEY=your_livekit_api_key
LIVEKIT_API_SECRET=your_livekit_api_secret
GOOGLE_API_KEY=your_google_api_key
```

### 4. Run the Agent

```bash
python agent.py console
```

---

## Working Flow

- User gives input (voice or text)
- Language is detected automatically
- Relevant legal context is retrieved (RAG)
- AI generates response using:
  - Legal sections
  - Simple explanation
- Output is converted to speech

---

## Response Rules

- Maximum 60 words
- Must include IPC, BNS, or CrPC section
- No complex legal jargon
- Clear and conversational tone
- Suitable for voice output

### Example

**User:**  
Someone cheated me. What should I do?

**Response:**  
Under IPC Section 420, cheating is a criminal offense. You can file an FIR under CrPC Section 154 at your nearest police station. Keep proof like messages or transactions. It is better to consult a lawyer for proper guidance.

---

## Safety Note

Nyaya Mitr provides general legal information only. It is not a substitute for a professional lawyer. Always consult a legal expert for serious cases.

---

## Future Scope

- Court document generation
- Case prediction system
- State-specific legal rules
- Mobile app integration
- Legal database connection

---

## License

MIT License

---

## Contact

ravichandran34546@gmail.com
