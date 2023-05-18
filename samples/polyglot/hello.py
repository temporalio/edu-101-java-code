
from temporalio import activity


@activity.defn
async def greet_in_spanish(name: str) -> str:
    return f"Hello {name}"