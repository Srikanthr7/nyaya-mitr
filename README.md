# AMI

AMI is an AI-powered negotiator agent designed for high-stakes marketplace scenarios. The agent adopts a selectable persona and negotiates deals in real time, aiming to maximize profit (if Seller) or minimize cost (if Buyer) while staying true to its character. AMI leverages Google Gemini models and LiveKit Cloud for voice and messaging, with enhanced noise cancellation for clear communication.

## Features

- **Persona-driven negotiation:** Choose from Aggressive Trader, Smooth Diplomat, Data-Driven Analyst, or Creative Wildcard.
- **Real-time voice and text negotiation** using LiveKit Cloud.
- **Scoring system:** Optimizes for profit/savings, character consistency, and negotiation speed.
- **Noise cancellation:** Ensures high-quality audio in calls.

## Getting Started

### Prerequisites

- Python 3.8+
- LiveKit Cloud account and API credentials
- Google Gemini API access

### Installation

1. Clone the repository:
    ```sh
    git clone <your-repo-url>
    cd ami
    ```

2. Install dependencies:
    ```sh
    pip install -r requirements.txt
    ```

3. Create a `.env` file in the project root with your credentials:
    ```
    LIVEKIT_API_KEY=your_livekit_api_key
    LIVEKIT_API_SECRET=your_livekit_api_secret
    GOOGLE_API_KEY=your_google_api_key
    ```

### Usage

Start the agent with:

```sh
python agent.py console
```

The agent will connect to LiveKit Cloud and begin negotiating in the selected room.

## Project Structure

- `agent.py` — Main agent logic and entrypoint.
- `prompt.py` — Agent instructions and persona response examples.
- `requirements.txt` — Python dependencies.

## Persona Styles

- **Aggressive Trader:** Pushy, urgent, hard-bargaining.
- **Smooth Diplomat:** Polite, persuasive, win-win focus.
- **Data-Driven Analyst:** Logical, fact-based, cites market data.
- **Creative Wildcard:** Playful, surprising, unconventional.

## License

MIT License

## Contact

For questions or support, contact [ravichandran34546@gmail.com]
